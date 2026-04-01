package br.unicesumar.projeto_1.rubro_negra;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Árvore Rubro-Negra — implementação baseada em CLRS (Cormen et al.)
 *
 * Propriedades mantidas em todo momento:
 *   1. Todo nó é Rubro ou Negro.
 *   2. A raiz é sempre Negra.
 *   3. Todo nó folha (NIL sentinela) é Negro.
 *   4. Se um nó é Rubro, ambos os filhos são Negros (sem dois Rubros consecutivos).
 *   5. Para qualquer nó, todos os caminhos até as folhas descendentes
 *      contêm o mesmo número de nós Negros (altura-negra uniforme).
 *
 * Uso do sentinela NIL:
 *   Em vez de null, usa-se um único nó sentinela NIL (sempre Negro).
 *   Isso elimina casos especiais nas rotações e fixups.
 */
public class RBT {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    final Node NIL; //sentinela: folhas null
    Node root;
    public RBT() {
        //o sentinela NIL aponta para si mesmo em todos os campos
        NIL = new Node(0);
        NIL.isRed = BLACK;
        NIL.left = NIL;
        NIL.right = NIL;
        NIL.parent = NIL;
        root = NIL; //arvore null = raiz aponta para NIL
    }

    /*
     * Rotação à esquerda em torno de x:
     *
     *     x                y
     *    / \      →       / \
     *   A   y            x   C
     *      / \          / \
     *     B   C        A   B
     */
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == NIL) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    /*
     * Rotação à direita em torno de x (espelho de rotateLeft):
     *
     *       x              y
     *      / \    →       / \
     *     y   C          A   x
     *    / \                / \
     *   A   B              B   C
     */
    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == NIL) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insert(int key) {
        Node z = new Node(key);
        z.left = NIL;
        z.right = NIL;
        z.parent = NIL;
        z.isRed = RED;
        Node y = NIL;
        Node x = root;
        while (x != NIL) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else if (z.key > x.key) {
                x = x.right;
            } else {
                System.out.println("Valor já existe, não será inserido.");
                return;
            }
        }
        z.parent = y;
        if (y == NIL) {
            root = z; //arvore era null, agora tem um novo no raiz
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        insertFixup(z); //corrige possiveis violaçoes das regras pra arvore rubro negra
    }

    //correçoes seguindo as regras de uma arvore rubro negra
    /*
     * A única propriedade que pode ser violada é a #4 (dois Rubros consecutivos),
     * pois z é inserido como Rubro. O loop sobe pela árvore enquanto o pai é Rubro.
     *
     * Caso 1 — Tio é Rubro: recolorir pai, tio → Negro; avô → Rubro; subir para avô.
     * Caso 2 — Tio é Negro, z é filho "interno": rotacionar o pai, transformar em Caso 3.
     * Caso 3 — Tio é Negro, z é filho "externo": rotacionar o avô + recolorir.
     */
    private void insertFixup(Node z) {
        while (z.parent.isRed == RED) {
            if (z.parent == z.parent.parent.left) {
                // pai é filho ESQUERDO do avo
                Node tio = z.parent.parent.right;
                if (tio.isRed == RED) {
                    //caso 1
                    z.parent.isRed = BLACK;
                    tio.isRed = BLACK;
                    z.parent.parent.isRed = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        //caso 2
                        z = z.parent;
                        rotateLeft(z);
                    }
                    //caso 3
                    z.parent.isRed = BLACK;
                    z.parent.parent.isRed = RED;
                    rotateRight(z.parent.parent);
                }
            } else {
                //pai é filho DIREITO do avo (espelho dos casos acima)
                Node tio = z.parent.parent.left;
                if (tio.isRed == RED) {
                    //caaso 1 (mirror)
                    z.parent.isRed = BLACK;
                    tio.isRed = BLACK;
                    z.parent.parent.isRed = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        //caso 2 (mirror)
                        z = z.parent;
                        rotateRight(z);
                    }
                    //caso 3 (mirror)
                    z.parent.isRed = BLACK;
                    z.parent.parent.isRed = RED;
                    rotateLeft(z.parent.parent);
                }
            }
        }
        root.isRed = BLACK; //garante propriedade 2
    }

    public Node search(int key) {
        Node current = root;
        while (current != NIL) {
            if (key == current.key) {
                return current;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public int calculateHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node node) {
        if (node == NIL) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void remove(int key) {
        Node z = findNode(key);
        if (z == NIL) {
            System.out.println("Valor " + key + " não encontrado.");
            return;
        }
        delete(z);
    }

    private Node findNode(int key) {
        Node current = root;
        while (current != NIL) {
            if (key == current.key) return current;
            else if (key < current.key) current = current.left;
            else current = current.right;
        }
        return NIL;
    }

    /*
     * Transplante substitui a subárvore enraizada em U pela subárvore enraizada em V.
     */
    //usado para reconectar o pai de u a v durante a remoçao
    private void transplant(Node u, Node v) {
        if (u.parent == NIL) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    //remove o no z mantendo as propriedades:
    // y = no removido (z se tiver <=1 filho, senao sucessor de z)
    // x = filho que substitui y na arvore
    //
    // se y era negro, a "altura-negra" foi violada entao -> deleteFixup(x)
    private void delete(Node z) {
        Node y = z;
        Node x;
        boolean yOriginalColor = y.isRed;
        if (z.left == NIL) {
            //z nao tem filho esquerdo
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == NIL) {
            //z nao tem filho direito
            x = z.left;
            transplant(z, z.left);
        } else {
            //z tem dois filhos -> usa o sucessor in-order = menor da subarvore direita
            y = smallestValue(z.right);
            yOriginalColor = y.isRed;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.isRed = z.isRed; //y herda a cor de z
        }
        if (yOriginalColor == BLACK) {
            deleteFixup(x); //se no removido era negro
        }
    }

    /*
     * Corrige violações após remoção de um nó Negro.
     *
     * x carrega um double-black. O loop remove esse crédito extra.
     *
     * Caso 1 — Irmão W é Rubro: rotacionar pai, transformar em casos 2/3/4.
     * Caso 2 — W é Negro com dois filhos Negros: recolorir W → Rubro; subir x.
     * Caso 3 — W é Negro, filho distante de W é Negro, próximo é Rubro: rotacionar W + recolorir → Caso 4.
     * Caso 4 — W é Negro, filho distante de W é Rubro: rotacionar pai + recolorir; encerrar.
     */
    private void deleteFixup(Node x) {
        while (x != root && x.isRed == BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right; //irmao de x
                if (w.isRed == RED) {
                    //caso 1
                    w.isRed = BLACK;
                    x.parent.isRed = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if (w.left.isRed == BLACK && w.right.isRed == BLACK) {
                    //caso 2
                    w.isRed = RED;
                    x = x.parent;
                } else {
                    if (w.right.isRed == BLACK) {
                        //caso 3
                        w.left.isRed = BLACK;
                        w.isRed = RED;
                        rotateRight(w);
                        w = x.parent.right;
                    }
                    //caso 4
                    w.isRed = x.parent.isRed;
                    x.parent.isRed = BLACK;
                    w.right.isRed = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                //espelho: x = filho DIREITO
                Node w = x.parent.left;
                if (w.isRed == RED) {
                    //caso 1 (mirror)
                    w.isRed = BLACK;
                    x.parent.isRed = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if (w.right.isRed == BLACK && w.left.isRed == BLACK) {
                    //caso 2 (mirror)
                    w.isRed = RED;
                    x = x.parent;
                } else {
                    if (w.left.isRed == BLACK) {
                        //caso 3 (mirror)
                        w.right.isRed = BLACK;
                        w.isRed = RED;
                        rotateLeft(w);
                        w = x.parent.left;
                    }
                    //caso 4 (mirror)
                    w.isRed = x.parent.isRed;
                    x.parent.isRed = BLACK;
                    w.left.isRed = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.isRed = BLACK; //garante que x (possivelmente raiz) seja negro
    }

    private Node smallestValue(Node node) {
        while (node.left != NIL) {
            node = node.left;
        }
        return node;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node current) {
        if (current == NIL) return;
        printTree(current.left);
        //verifica cor do no (R or B)
        System.out.print(current.key + (current.isRed ? "[R]" : "[B]") + " ");
        printTree(current.right);
    }

    public void printByLevel() {
        if (root == NIL) return;
        int height = calculateHeight();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = (int) Math.pow(2, height) - 1;
        for (int level = 0; level < height; level++) {
            int levelSize = queue.size();
            int spaces = maxWidth / (int) Math.pow(2, level + 1);
            printSpaces(spaces);
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current == null) {
                    //placeholder
                    System.out.print("n");
                    queue.add(null);
                    queue.add(null);
                } else {
                    //verifica cor do no
                    System.out.println(current.key + (current.isRed ? "R" : "B"));
                    //converte NIL em null
                    if (current.left != NIL) {
                        queue.add(current.left);
                    } else {
                        queue.add(null);
                    }
                    if (current.right != NIL) {
                        queue.add(current.right);
                    } else {
                        queue.add(null);
                    }
                }
                printSpaces(spaces * 2 + 1);
            }
            System.out.println();
        }
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}

package ru.kurkin.redcollar_testtask.tree_structure;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    private BinaryTree tree = new BinaryTree();
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Загадай животное, а я попробую угадать...");
        while (tree.getCurrent().getRightNode()!=null) {
            System.out.println(tree.getCurrent().getData() + " y/n?");
            String answer = scanner.nextLine();
            roundAcrossTree(answer);
        }
        System.out.println("Это " + tree.getCurrent().getData() + "? y/n");
        String answer = scanner.nextLine();

        if (Objects.equals(answer, "y")) {
            System.out.println("Ура, я угадал!)\nСыграем еще? y/n");
            reset();
            answer = scanner.nextLine();
            if (Objects.equals(answer, "y")) {
                play();
            }
        } else if (Objects.equals(answer, "n")) {
            System.out.println("А какое животное ты загадал?");
            String answerForLearn = scanner.nextLine();
            System.out.println("Чем отличается " + answerForLearn + " от " + tree.getCurrent().getData() + "?");
            String newQuestion = scanner.nextLine();
            learn(answerForLearn, newQuestion);
            System.out.println("Хорошо, я запомню.");
            System.out.println("Сыграем еще? y/n");
            answer = scanner.nextLine();
            if (Objects.equals(answer, "y")) {
                play();
            }
        }
    }


    //Метод обхода дерева
    public void roundAcrossTree(String answer) {
        Node current = tree.getCurrent();
        if (Objects.equals(answer, "y")) {
            tree.setCurrent(current.getLeftNode());
        } else if (Objects.equals(answer, "n")) {
            tree.setCurrent(current.getRightNode());
        }
    }

    public void learn(String answerForLearn, String newQuestion) {
        Node parent = new Node(newQuestion);
        Node child = new Node(answerForLearn);
        tree.getCurrent().setRightNode(parent);
        tree.setCurrent(parent);
        tree.getCurrent().setLeftNode(child);
        reset();
    }
    private void reset(){
        tree.setCurrent(tree.getRoot());
    }
}

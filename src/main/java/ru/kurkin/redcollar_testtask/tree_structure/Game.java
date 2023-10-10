package ru.kurkin.redcollar_testtask.tree_structure;

import java.util.Scanner;

public class Game {
    private final BinaryTree tree = new BinaryTree();
    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        Node current = tree.getCurrent();
        System.out.println("Загадай животное, а я попробую угадать...");
        while (current != null && current.isQuestion()) {
            System.out.println(current.getData());
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("да")) {
                current = current.getLeftNode();
            } else if (answer.equals("нет")) {
                current = current.getRightNode();
            } else {
                System.out.println("Пожалуйста, ответьте 'да' или 'нет'.");
            }
        }
        if (current != null && !current.isQuestion()) {
            System.out.println("Я думаю, что вы загадали " + current.getData() + "!\nЭто так?");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("да")) {
                System.out.println("Ура, я выйграл!)\nСыграем снова?");
                answer = scanner.nextLine().toLowerCase();
                if (answer.equals("да")) {
                    play();
                }
            } else {
                System.out.println("Какое животное ты загадал?");
                String newAnimal = scanner.nextLine().toLowerCase();
                addNewAnimal(current, newAnimal);
            }

        }
    }

    private void addNewAnimal(Node current, String newAnimal) {

        System.out.println("Введите вопрос, который отличает " + current.getData() + " от " + newAnimal + ".");
        String newQuestion = scanner.nextLine();

        // Создаем новые узлы для нового животного и вопроса
        Node newAnimalNode = new Node(newAnimal);
        Node newQuestionNode = new Node(newQuestion);

        // Перемещаем текущие узлы вниз по дереву
        newQuestionNode.setRightNode(current);
        newQuestionNode.setLeftNode(newAnimalNode);

        // Заменяем текущий узел на новый вопрос
        Node root = tree.getRoot();
            Node parent = findParentNode(root, current);
            if (parent != null) {
                if (parent.getLeftNode() == current) {
                    parent.setLeftNode(newQuestionNode);
                } else if (parent.getRightNode() == current) {
                    parent.setRightNode(newQuestionNode);
                }
            }

        System.out.println("Спасибо за игру! Теперь я знаю больше животных!\nСыграем снова?");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("да")){
            play();
        }else{
            System.out.println("пока");
        }
    }

    private Node findParentNode(Node current, Node targetNode) {
        if (current == null) {
            return null;
        }

        if (current.getLeftNode() == targetNode || current.getRightNode() == targetNode) {
            return current;
        }
        Node parentNode = findParentNode(current.getLeftNode(), targetNode);
        if (parentNode == null) {
            parentNode = findParentNode(current.getRightNode(), targetNode);
        }

        return parentNode;
    }
}

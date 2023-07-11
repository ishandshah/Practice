/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.util.LinkedList;
import java.util.Objects;
//todo atlassian
public class SnakeGame {
    private static final int BOARD_SIZE = 10;

    private LinkedList<Point> snake;
    private Direction currentDirection;
    private boolean gameOver;
    Point food;
    public SnakeGame() {
        initialize();
    }

    public void moveSnake(Direction direction) {
        if (gameOver) {
            System.out.println("Game over! Start a new game.");
            return;
        }

        Point head = snake.getFirst();
        Point newHead = getNextHeadPosition(head, direction);

        if (isCollision(newHead) || isOutOfBounds(newHead)) {
            gameOver = true;
            System.out.println("Game over! Score: " + (snake.size() - 1));
            return;
        }

        snake.addFirst(newHead);

        // Check if the snake has eaten food
        if (newHead.equals(food)) {
            generateFood();
        } else {
            snake.removeLast();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void initialize() {
        snake = new LinkedList<>();
        snake.add(new Point(BOARD_SIZE / 2, BOARD_SIZE / 2));
        currentDirection = Direction.RIGHT;
        generateFood();
        gameOver = false;
    }

    private void generateFood() {
        int x = (int) (Math.random() * BOARD_SIZE);
        int y = (int) (Math.random() * BOARD_SIZE);
        food = new Point(x, y);
    }

    private Point getNextHeadPosition(Point head, Direction direction) {
        int x = head.x;
        int y = head.y;

        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        return new Point(x, y);
    }

    private boolean isCollision(Point point) {
        // Check if the snake collided with itself
        return snake.contains(point);
    }

    private boolean isOutOfBounds(Point point) {
        // Check if the snake went out of bounds
        return point.x < 0 || point.y < 0 || point.x >= BOARD_SIZE || point.y >= BOARD_SIZE;
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();

        // Move the snake
        game.moveSnake(Direction.RIGHT);
        game.moveSnake(Direction.RIGHT);
        game.moveSnake(Direction.DOWN);
        game.moveSnake(Direction.LEFT);

        // Check if game is over
        if (game.isGameOver()) {
            System.out.println("Game over!");
        } else {
            System.out.println("Game still in progress...");
        }
    }
}

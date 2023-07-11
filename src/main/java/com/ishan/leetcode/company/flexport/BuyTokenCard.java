/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.flexport;

import java.util.HashMap;
import java.util.Map;

public class BuyTokenCard {


    public static void main(String[] args) {
        BuyTokenCard btc = new BuyTokenCard();
        Token greenToken = btc.new Token("green");
        Token redToken = btc.new Token("Red");
        Token blueToken = btc.new Token("Blue");
        Token blackToken = btc.new Token("Black");

        Map<Token, Integer> hash = new HashMap<>() {{
            put(greenToken, 5);
            put(redToken, 15);
            put(blueToken, 1);
            put(blackToken, 2);
        }};

        Player ishan = btc.new Player(hash);

        Card cardCost = btc.new Card(new HashMap<>() {{
            put(greenToken, 5);
            put(redToken, 11);
            put(blueToken, 1);
            put(blackToken, 2);
        }});

        System.out.println(ishan.canBuyCard(cardCost));
    }

    class Token {
        private String name;

        public Token(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Card {
        private Map<Token, Integer> cost;

        public Card(Map<Token, Integer> cost) {
            this.cost = cost;
        }

        public Map<Token, Integer> getCost() {
            return cost;
        }
    }

    class Player {
        private Map<Token, Integer> tokens;

        public Player(Map<Token, Integer> tokens) {
            this.tokens = tokens;
        }

        public Map<Token, Integer> getTokens() {
            return tokens;
        }

        public boolean canBuyCard(Card card) {
            Map<Token, Integer> cost = card.getCost();
            for (Map.Entry<Token, Integer> entry : cost.entrySet()) {
                Token token = entry.getKey();
                int required = entry.getValue();
                if (!tokens.containsKey(token) || tokens.get(token) < required) {
                    return false;
                }
            }
            return true;
        }
    }
}

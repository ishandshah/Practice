/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company;


import java.util.*;

//There is a conference where people from various countries are attending.
// Each person can speak only one language.
// When two people need to speak with each other and they don't speak the same language, translators are available.
// A translator knows only two languages and can translate both ways.
// Given as input the source and target language for translation and the list of translators along with languages they can translate,
// find the minimum number of translators (and the order in which they need to translate) to translate from source to target language.
//String source;
//String target;
//List<List<String>>
//[["Spanish","English"],["French","English"],["Spanish","French"],["French","Russian"]]
public class Turvo {

    public static Map<String, List<String>> translationMap = new HashMap<>();

    public static void main(String[] args) {
        String[][] translators = {{"Spanish", "English"}, {"French", "English"}, {"Spanish", "French"}, {"French", "Russian"}, {"Russian", "Hindi"}, {"French", "Hindi"}};
        populateMap(translators);
        System.out.println(findNo("English", "French"));
    }

    private static void populateMap(String[][] translators) {

        for (String[] input : translators) {
            if (translationMap.containsKey(input[0])) {
                List<String> inputList = translationMap.get(input[0]);
                inputList.add(input[1]);
                translationMap.put(input[0], inputList);
            } else {
                List<String> inputList = new ArrayList<>();
                inputList.add(input[1]);
                translationMap.put(input[0], inputList);

            }

            if (translationMap.containsKey(input[1])) {
                List<String> inputList = translationMap.get(input[1]);
                inputList.add(input[0]);
                translationMap.put(input[1], inputList);
            } else {
                List<String> inputList = new ArrayList<>();
                inputList.add(input[0]);
                translationMap.put(input[1], inputList);

            }

        }

    }

    private static int findNo(String sourceLanguage, String destinationLanguage) {
        int steps = 0;
        int currentSteps = 0;
        Set<String> visitedNodes = new HashSet<>();
        if (translationMap.containsKey(sourceLanguage) && translationMap.containsKey(destinationLanguage)) {

            List<String> firstTranslation = translationMap.get(destinationLanguage);
            visitedNodes.add(destinationLanguage);
            // HINDI -> RUSSIAN _. French -> SPANISH,ENGLISH
            Stack<String> translationQueue = new Stack<>();

            translationQueue.addAll(firstTranslation);

            while (!translationQueue.isEmpty()) {
                // BCD
                String currentDestination = translationQueue.pop();
                if (visitedNodes.contains(currentDestination)) {
                    continue;
                }
                visitedNodes.add(currentDestination);
                if (sourceLanguage.equals(currentDestination)) {
                    //
                    currentSteps++;
                    steps++;
                    if (currentSteps < steps) {
                        steps = currentSteps;
                    }
                } else {

                    translationQueue.addAll(translationMap.get(currentDestination));
                    currentSteps++;
                }

            }


        } else {

            System.out.println("No translator available");
            return -1;
        }

        System.out.println(steps);
        return steps;
    }
}

/* public int findTranslator(String source,String target,
		List<List<String>> languages
	){
		// Sam :: Preprocess data into hashmap
		Map<String,Set<String>> map = new HashMap<>();
		for(List<String> lang:languages){
			for(String l: lang){
				if(map.containsKey(l)){
					Set set= map.get(l);
					set.add(l);
					map.put(s,set);
				}else{
					map.put(l,new HashSet<>());
				}
			}
		}
		int counter = 0;
		Set<String> sourceSet = map.get(source);]
		boolean result;

		Queue<String>queue = new Queue();
		if(sourceSet.contains(target)){
			counter++;
		}else{
			// if source set doesnt contain the target
			queue.addAll(sourceSet);
			while(queue.isEmpty()){
				String queueElement = queue.pop();
				if(map.get(queueElement).contains(target)){
					counter++;
					result=true;
					return counter;
				}
				queue.addAll(map.get(queueElement));
				counter++;
			}
		}
		if(result == false ){
			return -1;
		}
*/
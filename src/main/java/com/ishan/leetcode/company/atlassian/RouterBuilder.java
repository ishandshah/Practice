/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassian;

import java.util.Map;
import java.util.regex.Pattern;

public class RouterBuilder {

    RouterImpl router;

    private RouterBuilder(){
        router =new RouterImpl();
    }

    //public s

    public RouterBuilder withMap(Map<Pattern,String> map){
            router.setRouterPath(map);
            return this;
    }

    public RouterImpl build(){
        return router;
    }
}

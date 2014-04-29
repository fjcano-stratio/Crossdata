/*
 * Stratio Meta
 *
 * Copyright (c) 2014, Stratio, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package com.stratio.meta.core.planner.statements;

import com.stratio.meta.core.planner.BasicPlannerTest;
import com.stratio.meta.core.statements.CreateTableStatement;
import com.stratio.meta.core.utils.MetaPath;
import com.stratio.meta.core.utils.Tree;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CreateTableStatementTest  extends BasicPlannerTest {

    @Test
    public void testPlan(){
        String inputText = "CREATE TABLE demo.new_table (id INT, name VARCHAR, check BOOLEAN, PRIMARY KEY (id, name));";
        Map<String, String> columns = new HashMap();
        columns.put("id", "INT");
        columns.put("name", "VARCHAR");
        columns.put("check", "BOOLEAN");
        stmt = new CreateTableStatement("demo.new_table", columns, Arrays.asList("id"), Arrays.asList("name"), 1, 1);
        ((CreateTableStatement)stmt).validate(_metadataManager, "demo");
        Tree tree = stmt.getPlan(_metadataManager,"demo");
        assertTrue(tree.getNode().getPath().equals(MetaPath.CASSANDRA));
    }
}
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.datavines.metric.plugin;

import io.datavines.common.config.CheckResult;
import io.datavines.metric.api.MetricDimension;
import io.datavines.metric.api.MetricType;
import io.datavines.metric.plugin.base.BaseSingleTable;

import java.util.Map;

public class ValueBetween extends BaseSingleTable {

    @Override
    public String getName() {
        return "value_between";
    }

    @Override
    public MetricDimension getDimension() {
        return MetricDimension.COMPLETENESS;
    }

    @Override
    public MetricType getType() {
        return MetricType.SINGLE_TABLE;
    }

    @Override
    public boolean isInvalidateItemsCanOutput() {
        return true;
    }

    @Override
    public CheckResult validateConfig(Map<String, String> config) {
        return null;
    }

    @Override
    public void prepare(Map<String, String> config) {
        super.prepare(config);

        if (config.containsKey("src_min")) {
            filters.add("${src_column} >= ${src_min}");
        }

        if (config.containsKey("src_max")) {
            filters.add("${src_column} <= ${src_max}");
        }

        addFiltersIntoInvalidateItemsSql();
    }
}

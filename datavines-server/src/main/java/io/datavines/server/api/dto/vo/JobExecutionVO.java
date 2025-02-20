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
package io.datavines.server.api.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.datavines.common.enums.ExecutionStatus;
import io.datavines.common.enums.JobType;
import io.datavines.core.utils.LanguageUtils;
import io.datavines.server.enums.DqJobExecutionState;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class JobExecutionVO implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;

    private String schemaName;

    private String tableName;

    private String columnName;

    private String metricType;

    private JobType jobType;

    private ExecutionStatus status;

    private DqJobExecutionState checkState;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime endTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;

    public String getJobType() {
        return LanguageUtils.isZhContext()? jobType.getZhDescription() : jobType.getDescription();
    }

    public String getCheckState() {
        if (checkState == null) {
            return LanguageUtils.isZhContext()? DqJobExecutionState.NONE.getZhDescription() : DqJobExecutionState.NONE.getDescription();
        }
        return LanguageUtils.isZhContext()? checkState.getZhDescription() : checkState.getDescription();
    }

    public String getStatus() {
        return LanguageUtils.isZhContext()? status.getZhDescription() : status.getDescription();
    }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.core.analysis.generated.endpointrelation;

import java.util.*;
import lombok.*;
import org.apache.skywalking.oap.server.core.Const;
import org.apache.skywalking.oap.server.core.alarm.AlarmMeta;
import org.apache.skywalking.oap.server.core.alarm.AlarmSupported;
import org.apache.skywalking.oap.server.core.analysis.indicator.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.annotation.IndicatorType;
import org.apache.skywalking.oap.server.core.remote.annotation.StreamData;
import org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteData;
import org.apache.skywalking.oap.server.core.storage.annotation.*;
import org.apache.skywalking.oap.server.core.storage.StorageBuilder;
import org.apache.skywalking.oap.server.core.source.Scope;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */
@IndicatorType
@StreamData
@StorageEntity(name = "endpoint_relation_resp_time", builder = EndpointRelationRespTimeIndicator.Builder.class)
public class EndpointRelationRespTimeIndicator extends LongAvgIndicator implements AlarmSupported {

    @Setter @Getter @Column(columnName = "entity_id") @IDColumn private java.lang.String entityId;
    @Setter @Getter @Column(columnName = "service_id")  private int serviceId;
    @Setter @Getter @Column(columnName = "child_service_id")  private int childServiceId;
    @Setter @Getter @Column(columnName = "service_instance_id")  private int serviceInstanceId;
    @Setter @Getter @Column(columnName = "child_service_instance_id")  private int childServiceInstanceId;

    @Override public String id() {
        String splitJointId = String.valueOf(getTimeBucket());
        splitJointId += Const.ID_SPLIT + entityId;
        return splitJointId;
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + entityId.hashCode();
        result = 31 * result + (int)getTimeBucket();
        return result;
    }


    @Override public int remoteHashCode() {
        int result = 17;
        result = 31 * result + entityId.hashCode();
        return result;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        EndpointRelationRespTimeIndicator indicator = (EndpointRelationRespTimeIndicator)obj;
        if (!entityId.equals(indicator.entityId))
            return false;

        if (getTimeBucket() != indicator.getTimeBucket())
            return false;

        return true;
    }

    @Override public RemoteData.Builder serialize() {
        RemoteData.Builder remoteBuilder = RemoteData.newBuilder();
        remoteBuilder.setDataStrings(0, getEntityId());

        remoteBuilder.setDataLongs(0, getSummation());
        remoteBuilder.setDataLongs(1, getValue());
        remoteBuilder.setDataLongs(2, getTimeBucket());


        remoteBuilder.setDataIntegers(0, getServiceId());
        remoteBuilder.setDataIntegers(1, getChildServiceId());
        remoteBuilder.setDataIntegers(2, getServiceInstanceId());
        remoteBuilder.setDataIntegers(3, getChildServiceInstanceId());
        remoteBuilder.setDataIntegers(4, getCount());

        return remoteBuilder;
    }

    @Override public void deserialize(RemoteData remoteData) {
        setEntityId(remoteData.getDataStrings(0));

        setSummation(remoteData.getDataLongs(0));
        setValue(remoteData.getDataLongs(1));
        setTimeBucket(remoteData.getDataLongs(2));


        setServiceId(remoteData.getDataIntegers(0));
        setChildServiceId(remoteData.getDataIntegers(1));
        setServiceInstanceId(remoteData.getDataIntegers(2));
        setChildServiceInstanceId(remoteData.getDataIntegers(3));
        setCount(remoteData.getDataIntegers(4));


    }

    @Override public AlarmMeta getAlarmMeta() {
        return new AlarmMeta("endpoint_relation_resp_time", Scope.EndpointRelation, entityId);
    }

    @Override
    public Indicator toHour() {
        EndpointRelationRespTimeIndicator indicator = new EndpointRelationRespTimeIndicator();
        indicator.setTimeBucket(toTimeBucketInHour());
        indicator.setEntityId(this.getEntityId());
        indicator.setServiceId(this.getServiceId());
        indicator.setChildServiceId(this.getChildServiceId());
        indicator.setServiceInstanceId(this.getServiceInstanceId());
        indicator.setChildServiceInstanceId(this.getChildServiceInstanceId());
        indicator.setSummation(this.getSummation());
        indicator.setCount(this.getCount());
        indicator.setValue(this.getValue());
        return indicator;
    }

    @Override
    public Indicator toDay() {
        EndpointRelationRespTimeIndicator indicator = new EndpointRelationRespTimeIndicator();
        indicator.setTimeBucket(toTimeBucketInDay());
        indicator.setEntityId(this.getEntityId());
        indicator.setServiceId(this.getServiceId());
        indicator.setChildServiceId(this.getChildServiceId());
        indicator.setServiceInstanceId(this.getServiceInstanceId());
        indicator.setChildServiceInstanceId(this.getChildServiceInstanceId());
        indicator.setSummation(this.getSummation());
        indicator.setCount(this.getCount());
        indicator.setValue(this.getValue());
        return indicator;
    }

    @Override
    public Indicator toMonth() {
        EndpointRelationRespTimeIndicator indicator = new EndpointRelationRespTimeIndicator();
        indicator.setTimeBucket(toTimeBucketInMonth());
        indicator.setEntityId(this.getEntityId());
        indicator.setServiceId(this.getServiceId());
        indicator.setChildServiceId(this.getChildServiceId());
        indicator.setServiceInstanceId(this.getServiceInstanceId());
        indicator.setChildServiceInstanceId(this.getChildServiceInstanceId());
        indicator.setSummation(this.getSummation());
        indicator.setCount(this.getCount());
        indicator.setValue(this.getValue());
        return indicator;
    }

    public static class Builder implements StorageBuilder<EndpointRelationRespTimeIndicator> {

        @Override public Map<String, Object> data2Map(EndpointRelationRespTimeIndicator storageData) {
            Map<String, Object> map = new HashMap<>();
            map.put("entity_id", storageData.getEntityId());
            map.put("service_id", storageData.getServiceId());
            map.put("child_service_id", storageData.getChildServiceId());
            map.put("service_instance_id", storageData.getServiceInstanceId());
            map.put("child_service_instance_id", storageData.getChildServiceInstanceId());
            map.put("summation", storageData.getSummation());
            map.put("count", storageData.getCount());
            map.put("value", storageData.getValue());
            map.put("time_bucket", storageData.getTimeBucket());
            return map;
        }

        @Override public EndpointRelationRespTimeIndicator map2Data(Map<String, Object> dbMap) {
            EndpointRelationRespTimeIndicator indicator = new EndpointRelationRespTimeIndicator();
            indicator.setEntityId((String)dbMap.get("entity_id"));
            indicator.setServiceId(((Number)dbMap.get("service_id")).intValue());
            indicator.setChildServiceId(((Number)dbMap.get("child_service_id")).intValue());
            indicator.setServiceInstanceId(((Number)dbMap.get("service_instance_id")).intValue());
            indicator.setChildServiceInstanceId(((Number)dbMap.get("child_service_instance_id")).intValue());
            indicator.setSummation(((Number)dbMap.get("summation")).longValue());
            indicator.setCount(((Number)dbMap.get("count")).intValue());
            indicator.setValue(((Number)dbMap.get("value")).longValue());
            indicator.setTimeBucket(((Number)dbMap.get("time_bucket")).longValue());
            return indicator;
        }
    }
}

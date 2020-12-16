package com.jiangwei.authserver.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
    * org_entity
    */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgEntity {
    /**
    * orgId
    */
    private Long orgId;

    /**
    * orgName
    */
    private String orgName;

    /**
    * gmtTime
    */
    private Date gmtTime;

    /**
    * parentId
    */
    private Long parentId;

    /**
    * sortNum
    */
    private Integer sortNum;
}
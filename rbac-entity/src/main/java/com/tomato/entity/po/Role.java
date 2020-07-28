package com.tomato.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    private Long id;
    private String roleName;
    private String roleDesc;
}

package com.tomato.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    private Long id;
    private String username;
    private String password;
    private List<Role> roles;

}

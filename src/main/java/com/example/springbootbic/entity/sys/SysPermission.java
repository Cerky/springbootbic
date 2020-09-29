package com.example.springbootbic.entity.sys;

/**
 * 资源权限
 * @Author CZJ
 * @Date 2020/09/28
 */
public class SysPermission {
    /**
     * 编号
     */
    private Long id;

    /**
     * 权限编号
     */
    private String permission;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 是否锁定
     */
    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
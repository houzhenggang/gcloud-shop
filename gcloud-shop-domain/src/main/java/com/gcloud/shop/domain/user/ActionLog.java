package com.gcloud.shop.domain.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ActionLog
 * @Package com.gcloud.domain.user
 * @Description: 操作日志
 * @date 2016/6/1 13:53
 */
public class ActionLog implements Serializable {

    private static final long serialVersionUID = 9108947433332645888L;

    /**
     * id
     */
    private Long id;
    /**
     * taobao_id
     */
    private Long taobaoId;
    /**
     * nick
     */
    private String nick;
    /**
     * 操作时间
     */
    private Date actionTime;
    /**
     * 操作模块
     */
    private String action;
    /**
     * 操作详细参数
     */
    private String actionParam;

    /**
     * 消费时间
     */
    private Long speedTime;

    /**
     * 操作结果
     */
    private String actionResult;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(Long taobaoId) {
        this.taobaoId = taobaoId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionParam() {
        return actionParam;
    }

    public void setActionParam(String actionParam) {
        this.actionParam = actionParam;
    }

    public Long getSpeedTime() {
        return speedTime;
    }

    public void setSpeedTime(Long speedTime) {
        this.speedTime = speedTime;
    }

    public String getActionResult() {
        return actionResult;
    }

    public void setActionResult(String actionResult) {
        this.actionResult = actionResult;
    }
}
package com.wkcheng.sqlite;


public class TransferBase {
    private String transferId;

    private String module;

    private String title;

    private String status;

    private Integer isDelete;

    private String audioPath;

    private Long duration;

    private String createdTime;

    private String beginTime;

    private String updateTime;

    private String endTime;

    public TransferBase() {
    }


    /**
     * 生成音频改变用的更新实体
     *
     * @param transferId ：转写标识
     * @param audioPath  ：待更新的音频地址
     * @return ：更新用的实体
     */
    public static TransferBase generateAudioPathChangeEntity(String transferId, String audioPath, Long duration) {
        return new TransferBase().setTransferId(transferId).setAudioPath(audioPath)
                .setDuration(duration);
    }

    /**
     * audioPath getter
     *
     * @return ：return audioPath with type java.lang.String
     */
    public String getAudioPath() {
        return audioPath;
    }

    /**
     * audioPath setter
     *
     * @param audioPath : audioPath with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setAudioPath(String audioPath) {
        this.audioPath = audioPath;
        return this;
    }

    /**
     * beginTime getter
     *
     * @return ：return beginTime with type java.lang.String
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * beginTime setter
     *
     * @param beginTime : beginTime with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setBeginTime(String beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    /**
     * createdTime getter
     *
     * @return ：return createdTime with type java.lang.String
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * duration getter
     *
     * @return ：return duration with type java.lang.Integer
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * duration setter
     *
     * @param duration : duration with type java.lang.Integer
     * @return : TransferBase
     */
    public TransferBase setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * endTime getter
     *
     * @return ：return endTime with type java.lang.String
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * endTime setter
     *
     * @param endTime : endTime with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * isDelete getter
     *
     * @return ：return isDelete with type java.lang.Integer
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * isDelete setter
     *
     * @param isDelete : isDelete with type java.lang.Integer
     * @return : TransferBase
     */
    public TransferBase setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    /**
     * module getter
     *
     * @return ：return module with type java.lang.String
     */
    public String getModule() {
        return module;
    }

    /**
     * module setter
     *
     * @param module : module with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setModule(String module) {
        this.module = module;
        return this;
    }

    /**
     * status getter
     *
     * @return ：return status with type java.lang.String
     */
    public String getStatus() {
        return status;
    }

    /**
     * status setter
     *
     * @param status : status with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * title getter
     *
     * @return ：return title with type java.lang.String
     */
    public String getTitle() {
        return title;
    }

    /**
     * title setter
     *
     * @param title : title with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * transferId getter
     *
     * @return ：return transferId with type java.lang.String
     */
    public String getTransferId() {
        return transferId;
    }

    /**
     * transferId setter
     *
     * @param transferId : transferId with type java.lang.String
     * @return : TransferBase
     */
    public TransferBase setTransferId(String transferId) {
        this.transferId = transferId;
        return this;
    }

    /**
     * updateTime getter
     *
     * @return ：return updateTime with type java.lang.String
     */
    public String getUpdateTime() {
        return updateTime;
    }
}
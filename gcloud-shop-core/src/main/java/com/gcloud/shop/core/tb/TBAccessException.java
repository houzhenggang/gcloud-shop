package com.gcloud.shop.core.tb;

import com.gcloud.shop.api.TaobaoResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TBAccessException
 * @Package com.gcloud.shop.core.tb
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 16:24
 */
public class TBAccessException extends RuntimeException {

    private static Map<String, String> stringStringMap = new HashMap<String, String>();
    static {
        stringStringMap.put("isv.logistics-offline-service-error:B01", "订单不存在，建议重新同步下订单");
        stringStringMap.put("isv.logistics-offline-service-error:B02", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-offline-service-error:B04", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-online-service-error:B04", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-dummy-service-error:B04", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-offline-service-error:B56", "没有选择物流公司");
        stringStringMap.put("isv.logistics-offline-service-error:B59", "运单号为空");
        stringStringMap.put("isv.logistics-offline-service-error:B60", "运单号不符合规则或已经被使用");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P10", "运单号不符合规则或已经被使用");
        stringStringMap.put("isv.invalid-parameter", "数据为空或格式不对");
        stringStringMap.put("isv.logistics-offline-service-error:P01", "数据为空或格式不对");
        stringStringMap.put("isv.logistics-offline-service-error:B101", "地址库不存在或该地址库不属于当前用户");
        stringStringMap.put("isv.logistics-offline-service-error:P03", "会话已过期，请重新登录系统 ");
        stringStringMap.put("isv.logistics-offline-service-error:B27", "已经生成发货单的订单不能发货 ");
        stringStringMap.put("isv.logistics-offline-service-error:B58", "物流公司名称过长,长度小于20个字符 ");
        stringStringMap.put("isv.logistics-offline-service-error:B57", "该物流公司不支持自己联系");
        stringStringMap.put("isv.logistics-offline-service-error:B55", "订单状态不对，建议重新同步下订单 ");
        stringStringMap.put("isv.logistics-offline-service-error:B109", "对不起，您尚未成功订购E速宝物流服务");
        stringStringMap.put("isv.logistics-offline-service-error:B110", "对不起，该订单超出了E速宝的服务范围，请联系小二处理 ");
        stringStringMap.put("isv.logistics-offline-service-error:P25", "不支持对拆单订单进行操作");
        stringStringMap.put("isv.logistics-offline-service-error:F	", "请使用正确的运单号 ");
        stringStringMap.put("isv.logistics-offline-service-error:F01", "您填写的运单号已经过期无效");
        stringStringMap.put("isv.logistics-offline-service-error:F02", "订单付款时间晚于快递公司揽收时间，运单号不能使用");
        stringStringMap.put("isv.logistics-offline-service-error:F03", "收货人地址信息与快递公司签收地址信息不匹配");
        stringStringMap.put("isv.logistics-offline-service-error:F04", "您填写的运单号已被使用");
        stringStringMap.put("isv.logistics-offline-service-error:F05", "您填写的运单号已被使用");
        stringStringMap.put("isv.logistics-offline-service-error:F06", "您的收货人信息与发货人信息一致，不允许发货");
        stringStringMap.put("isv.logistics-offline-service-error:CD25", "拆单标记和子订单列表两者必须都填或者都不填");
        stringStringMap.put("isv.logistics-offline-service-error:CD26", "拆分的子订单没有传子订单号");
        stringStringMap.put("isv.logistics-offline-service-error:CD22", "订单已拆单，必须传入子交易号列表");
        stringStringMap.put("isv.logistics-offline-service-error:CD23", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-offline-service-error:CD24", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-offline-service-error:CD27", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-offline-service-error:CD28", "淘宝后台拆单异常");
        stringStringMap.put("isv.logistics-offline-service-error::B05", "未查到物流订单，建议重新同步下订单");
        stringStringMap.put("isv.logistics-offline-service-error:CD29", "订单不是拆单订单，拆单标记和子订单列表都不能传入");
        stringStringMap.put("isv.logistics-offline-service-error:B06", "传入的子订单号必须完全匹配物流包裹中的子订单");
        stringStringMap.put("isv.logistics-offline-service-error:CD30", "请传入正确的用户ID或订单号");
        stringStringMap.put("isv.logistics-offline-service-error:CD31", "非拆单订单的物流订单数不等于1");
        stringStringMap.put("isv.logistics-offline-service-error:P02", "订单不存在，建议重新同步下订单");
        stringStringMap.put("isv.logistics-offline-service-error:P38", "拆单校验未通过");
        stringStringMap.put("isv.logistics-offline-service-error:B98", "发货类型不匹配，如虚拟商品订单、家装类订单等");
        stringStringMap.put("isv.logistics-offline-service-error:P22", "数据格式不对");
        stringStringMap.put("isv.logistics-offline-service-error:P38", "拆单校验未通过");
        stringStringMap.put("isv.logistics-offline-service-error:S01", "数据异常，稍后请重试");
        stringStringMap.put("isp.logistics-online-service-error:S01", "数据异常，稍后请重试");
        stringStringMap.put("isv.invalid-parameter:seller_nick:P17", "请传入正确的用户ID或订单号");
        stringStringMap.put("isv.invalid-parameter:closereason_wrong", "关闭理由不正确");
        stringStringMap.put("isv.logistics-offline-service-error:B150", "发货异常，请稍等后重试");
        stringStringMap.put("isv.logistics-order-cancel-service-error:P01", "传入数据异常");
        stringStringMap.put("isv.logistics-order-cancel-service-error:P02", "订单不存在，建议重新同步下订单");
        stringStringMap.put("isv.logistics-order-cancel-service-error:B04", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-order-cancel-service-error:CD17", "只有属于自己的订单才可以操作");
        stringStringMap.put("isv.logistics-order-cancel-service-error:R98", "系统超时,请重试 ");
        stringStringMap.put("isv.logistics-online-service-error:B01", "订单不存在，建议重新同步下订单");
        stringStringMap.put("isv.logistics-online-service-error:B02", "订单状态异常，建议重新同步下订单");
        stringStringMap.put("isv.logistics-online-service-error:B04", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-online-service-error:B56", "没有选择物流公司	或者物流公司格式不对");
        stringStringMap.put("isv.logistics-online-service-error:B59", "未传入运单号或者格式不对");
        stringStringMap.put("isv.logistics-online-service-error:P38", "拆单校验未通过");
        stringStringMap.put("isv.logistics-offline-service-error:P38", "拆单校验未通过");
        stringStringMap.put("isv.logistics-online-service-error:B60", "运单号不符合规则或已经被使用");
        stringStringMap.put("isv.invalid-parameter", "数据格式不对");
        stringStringMap.put("isv.logistics-online-service-error:B101", "地址库不存在或该地址库不属于当前用户");
        stringStringMap.put("isv.logistics-online-service-error:P01", "数据传入为空");
        stringStringMap.put("isv.logistics-online-service-error:B27", "已经生成发货单的订单不能发货 ");
        stringStringMap.put("isv.logistics-online-service-error:B52", "该物流公司不支持在线下单发货");
        stringStringMap.put("isv.logistics-online-service-error:B03", "	非c2c的订单不支持货到付款 ");
        stringStringMap.put("isv.logistics-online-service-error:p16", "未补签货到付款补充协议");
        stringStringMap.put("isv.logistics-online-service-error:B86", "该物流公司不支持货到付款");
        stringStringMap.put("isv.logistics-online-service-error:B79", "该物流公司揽收或派送范围不支持");
        stringStringMap.put("isp.logistics-online-service-error:S01 ", "数据异常，稍后请重试");
        stringStringMap.put("isv.logistics-online-service-error:B105", "该物流公司不支持在线下单");
        stringStringMap.put("isv.logistics-online-service-error:B55", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-online-service-error:P25", "不支持对拆单订单进行操作");
        stringStringMap.put("isv.logistics-online-service-error:F", "请使用正确的运单号 ");
        stringStringMap.put("isv.logistics-online-service-error:F01", "您填写的运单号已经过期无效");
        stringStringMap.put("isv.logistics-online-service-error:F02", "订单付款时间晚于快递公司揽收时间，运单号不能使用");
        stringStringMap.put("isv.logistics-online-service-error:F03", "收货人地址信息与快递公司签收地址信息不匹配");
        stringStringMap.put("isv.logistics-online-service-error:F04", "运单号已被使用，当前订单非真， 此物流单号不能使用	请使用正确的运单号 ");
        stringStringMap.put("isv.logistics-online-service-error:F05", "您填写的运单号已被使用");
        stringStringMap.put("isv.logistics-online-service-error:F06", "您填写的运单号已被使用");
        stringStringMap.put("isv.logistics-online-service-error:CD22", "订单已拆单，必须传入子交易号列表");
        stringStringMap.put("isv.logistics-online-service-error:CD23", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-online-service-error:CD24", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-online-service-error:CD25", "拆单标记和子订单列表两者必须都填或者都不填");
        stringStringMap.put("isv.logistics-online-service-error:CD26", "拆分的子订单没有传子订单号");
        stringStringMap.put("isv.logistics-online-service-error:CD27", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-online-service-error:CD28", "淘宝后台拆单异常");
        stringStringMap.put("isv.logistics-online-service-error:P03", "未找到对应子订单的物流包裹");
        stringStringMap.put("isv.logistics-online-service-error:B05", "未查到物流订单，建议重新同步下订单");
        stringStringMap.put("isv.logistics-online-service-error:CD29", "订单不是拆单订单，拆单标记和子订单列表都不能传入");
        stringStringMap.put("isv.logistics-online-service-error:B06", "传入的子订单号必须完全匹配物流包裹中的子订单");
        stringStringMap.put("isv.logistics-online-service-error:CD30", "请传入正确的用户ID或订单号 ");
        stringStringMap.put("isv.logistics-online-service-error:CD31", "非拆单订单的物流订单数不等于1");
        stringStringMap.put("isv.logistics-offline-service-error:B98", "发货类型不匹配，如虚拟商品订单、家装类订单等");
        stringStringMap.put("isv.logistics-offline-service-error:P22", "数据格式不对");
        stringStringMap.put("isv.logistics-offline-service-error:P38", "拆单校验未通过");
        stringStringMap.put("isv.invalid-parameter:seller_nick:P17", "请传入正确的用户ID或订单号");
        stringStringMap.put("isv.logistics-offline-service-error:B150", "发货异常，请稍后重试");
        stringStringMap.put("isv.logistics-confirm-service-error:P01", "数据为空或格式不对");
        stringStringMap.put("isv.logistics-confirm-service-error:P02", "订单不存在，建议重新同步下订单");
        stringStringMap.put("isv.logistics-confirm-service-error:CD17", "只有属于自己的订单才可以操作 ");
        stringStringMap.put("isv.logistics-confirm-service-error:CD16", "订单状态不对，建议重新同步下订单");
        stringStringMap.put("isv.logistics-confirm-service-error:HD06", "该物流订单已确认发货，不能重复确认发货 ");
        stringStringMap.put("isv.logistics-confirm-service-error:P03", "该物流公司无效，请重新选择物流公司发货 ");
        stringStringMap.put("isv.logistics-confirm-service-error:P25", "不支持对拆单订单进行操作 ");
        stringStringMap.put("isv.logistics-confirm-service-error:F", "请使用正确的运单号 ");
        stringStringMap.put("isv.logistics-confirm-service-error:F01", "您填写的运单号已经过期无效");
        stringStringMap.put("isv.logistics-confirm-service-error:F02", "订单付款时间晚于快递公司揽收时间，运单号不能使用");
        stringStringMap.put("isv.logistics-confirm-service-error:F03", "收货人地址信息与快递公司签收地址信息不匹配");
        stringStringMap.put("isv.logistics-confirm-service-error:F04", "您填写的运单号已被使用");
        stringStringMap.put("isv.logistics-confirm-service-error:F05", "您填写的运单号已被使用");
        stringStringMap.put("isv.logistics-confirm-service-error:F06", "您的收货人信息与发货人信息一致，不允许发货");
        stringStringMap.put("isv.logistics-confirm-service-error:CD18", "请填写正确的运单号");
        stringStringMap.put("isv.logistics-confirm-soervice-error:CD18", "请填写正确的运单号");
        stringStringMap.put("isv.logistics-confirm-soervice-error:CD16", "当前订单部分已发货，请拆单再发货");
        stringStringMap.put("isv.logistics-address-service-error:B104", "已存在相同的地址");
        stringStringMap.put("isv.logistics-confirm-service-error:CD22", "订单已拆单，必须传入子交易号列表");
        stringStringMap.put("isv.logistics-confirm-service-error:CD23", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-confirm-service-error:CD24", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-confirm-service-error:CD25", "拆单标记和子订单列表两者必须都填或者都不填");
        stringStringMap.put("isv.logistics-confirm-service-error:CD26", "拆分的子订单没有传子订单号");
        stringStringMap.put("isv.logistics-confirm-service-error:CD27", "订单已拆单，必须传入子交易号列表和拆单标记");
        stringStringMap.put("isv.logistics-confirm-service-error:CD28", "淘宝后台拆单异常");
        stringStringMap.put("isv.logisticst-confirm-service-error:CD29", "订单不是拆单订单，拆单标记和子订单列表都不能传入");
        stringStringMap.put("isv.logistics-confirm-service-error:B06", "传入的子订单号必须完全匹配物流包裹中的子订单");
        stringStringMap.put("isv.logistics-confirm-service-error:CD30", "请传入正确的用户ID或订单号");
        stringStringMap.put("isv.logistics-confirm-service-error:CD31", "非拆单订单的物流订单数不等于1");
        stringStringMap.put("isv.logistics-confirm-service-error:CD31", "非拆单订单的物流订单数不等于1");
        stringStringMap.put("isv.invalid-parameter:tid", "订单号不存在");
        stringStringMap.put("isv.invalid-parameterrb26", "该订单无法修改发货地址，请检查订单状态");
        stringStringMap.put("isv.logistics-offline-service-error:ORDER_NOT_FOUND_ERROR", "淘宝系统系统异常");
        stringStringMap.put("Missing required arguments:out_sid", "请输入运单号");
        stringStringMap.put("client-error:Missing Required Arguments:outSid", "请输入运单号");
        stringStringMap.put("This ban will last for 1 more seconds", "淘宝系统繁忙，请稍后重试..");
        stringStringMap.put("App Call Limited", "淘宝系统繁忙，请稍后重试..");
        stringStringMap.put("isp.top-remote-connection-timeout", "淘宝系统繁忙，请稍后重试..");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P01", "参数错误	校验入参是否正确");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P02", "该笔订单不是在系统内部[部分发货],不支持重新发货");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P03", "无效的物流公司	物流公司和不合法，请选择一个正确的物流公司");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P04", "无效的订单类型	检验logist_type不合法");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD19", "订单未发货	请先发货后再修改");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P05", "不支持的订单类型	只支持在线，COD,自己联系和保障速递的订单");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P06", "当前订单状态不支持修改	检验订单状态");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P07", "未作修改	确认是否需要调用本接口");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:P08", "该订单不支持修改。如不虚拟发货方式，这种方式该api 是不支持修改的	报错后应用程序做好控制，禁止重试，并做相应提示。");
        stringStringMap.put("isv.logistics-offline-service-error:P25", "	top         接口不允许对拆单订单操作	top 接口不允许对拆单订单进行操作");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F", "运单号被识别为假，无法发货	请使用正确的运单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F01", "您填写的运单号已经过期无效，不允许用此物流运单号发货	请使用正确的运单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F02", "您此笔交易订单付款时间晚于快递公司揽收时间，此物流运单号不能使用	请使用正确的运单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F03", "您此笔交易订单收货人地址信息与快递公司签收地址信息不匹配，此物流运单号不能使用	请使用正确的运单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F04", "运单号已被使用，当前订单非真， 此物流单号不能使用	请使用正确的运单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F05", "您填写的运单号已被使用，不允许用此物流运单号发货	请使用正确的运单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:F06", "您的收货人信息与发货人信息一致，不允许发货	请确认信息");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD22", "订单已拆单，必须传入子交易号列表	这个是已经被拆单的，操作这个订单发货时，必须带有子订单列表");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD23", "订单已拆单，请走拆单逻辑	订单已拆单，请走拆单逻辑,issplit和子订单列表必须都传入");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD24", "入参传入的主子交易号组合逻辑非法	入参传入的主子交易号组合逻辑非法，子订单列表不在对应的物流订单中，请传入对应的子订单列表");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD25", "拆单标记 和子订单列表两者必须都填或者都不填	拆单标记 和子订单列表两者必须都填或者都不填");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD26", "子订单交易号为空	当传递isSplit 为1后，必须传递该订单下的子订单交易号。");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD27", "订单已经被拆单,isSplit 必须是1	订单已经被拆单,isSplit 必须是1");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD28", "接入拆单异常	拆单逻辑未知错误，请确认发货参数");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:B05", "未查到物流订单	拆单订单校验子订单过程中未查到物流订单");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:B03", "传入的子订单号不同时在一个物流包裹中	传入的子订单号不同时在一个物流包裹中。传入订单时请输入同一个");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:B04", "其他异常	请确认输入订单参数后重试");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD29", "当前操作的订单不是拆单订单，拆单标记和子订单列表都不能带入	当前操作的订单不是拆单订单，拆单标记和子订单列表都不能带入");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:B06", "子订单号没有精确匹配	传入的子订单交易号必须完全匹配物流包裹中的子订单");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD30", "输入的用户Id或交易订单号不正确,未查到交易订单	请输入正确的用户ID和交易订单号");
        stringStringMap.put("isv.logistics-update-company-or-mailno-error:CD31", "非拆单订单的物流订单数不等于1	请联系淘宝物流开发");
        stringStringMap.put("isp.waybill-service-unavailable", "电子面单发货服务不支持");
    }

    private TaobaoResponse taobaoResp;

    public TaobaoResponse getTaobaoResp() {
        return taobaoResp;
    }

    public TBAccessException(String message) {
        super(message);
    }

    public TBAccessException(Throwable cause) {
        super(cause);
    }

    public TBAccessException(TaobaoResponse taobaoResp) {
        this.taobaoResp = taobaoResp;
    }


    public TBAccessException(String message, TaobaoResponse taobaoResp) {
        super(message);
        this.taobaoResp = taobaoResp;
    }

    public static String toConvertMsg(TaobaoResponse taobaoResp) {

        if (taobaoResp==null) {
            return "淘宝服务器未响应: ";
        }
        String msg = "";
        if (StringUtils.isNotEmpty(taobaoResp.getSubMsg()) && stringStringMap.containsKey(taobaoResp.getSubMsg())){
            msg = __toConvertMsg(taobaoResp.getSubMsg());
        } else if (StringUtils.isNotEmpty(taobaoResp.getSubCode()) && stringStringMap.containsKey(taobaoResp.getSubCode())){
            msg = __toConvertMsg(taobaoResp.getSubCode());
        } else if (StringUtils.isNotEmpty(taobaoResp.getMsg()) && stringStringMap.containsKey(taobaoResp.getMsg())){
            msg = __toConvertMsg(taobaoResp.getMsg());
        } else {
            msg = "淘宝接口异常: ";
            if (StringUtils.isNotEmpty(taobaoResp.getSubCode())) {
                msg += "SubCode[" + taobaoResp.getSubCode() + "];";
            }
            if (StringUtils.isNotEmpty(taobaoResp.getSubMsg())) {
                msg += "SubMsg[" + taobaoResp.getSubMsg() + "];";
            }
            if (StringUtils.isNotEmpty(taobaoResp.getMsg())){
                msg += "Msg[" + taobaoResp.getMsg() + "];";
            }
        }
        return msg;
    }

    private static String __toConvertMsg(String msg) {
        if (stringStringMap.containsKey(msg))
            return stringStringMap.get(msg);
        return msg;
    }

}
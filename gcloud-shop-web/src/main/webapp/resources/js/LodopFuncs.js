var CreatedOKLodop7766 = null;

function returnHtml(link) {
    var _html = '<div style="padding: 10px;"><ul><li style="height: 30px;line-height: 30px;padding-bottom: 20px"><img width="33" src="/resources/css/build/images/icon_1.png"/>&nbsp;&nbsp;亲，您还未安装打印插件或安装版本过低，&nbsp;<a class="btn btn-primary" href="' + link + '">下载插件</a></li>' +
        '<li style="height: 30px;line-height: 30px;"><img width="33" src="/resources/css/build/images/icon_2.png"/>&nbsp;&nbsp;安装之后，请点此&nbsp;<a class="btn btn-success" onclick="window.location.reload()">刷新</a></li></ul></div>';

    return _html;
}

function getLodop(_oOBJECT, _oEMBED) {
    var oOBJECT = document.getElementById('LODOP_OB');
    var oEMBED = document.getElementById('LODOP_EM');
    /**************************
     本函数根据浏览器类型决定采用哪个页面元素作为Lodop对象：
     IE系列、IE内核系列的浏览器采用oOBJECT，
     其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED,
     如果页面没有相关对象元素，则新建一个或使用上次那个,避免重复生成。
     64位浏览器指向64位的安装程序install_lodop64.exe。
     **************************/

    /*var strHtmInstall = "<div style='height: 30px; line-height: 30px; font-size: 14px; text-align: center; padding: 0 10px; background: #f9e5e5'><font color='#bb4944'>打印控件未安装！点击这里下载<a href='install_lodop32.exe' target='_self'>执行安装</a>，安装后请刷新页面或重新进入。</font></div>";

    var strHtmUpdate = "<div style='height: 30px; line-height: 30px; font-size: 14px; text-align: center; padding: 0 10px; background: #f9e5e5'><font color='#FF00FF'>打印控件需要升级！点击这里下载<a href='install_lodop32.exe' target='_self'>执行升级</a>，升级后请重新进入。</font></div>";

    var strHtm64_Install = "<div style='height: 30px; line-height: 30px; font-size: 14px; text-align: center; padding: 0 10px; background: #f9e5e5'><font color='#FF00FF'>打印控件未安装！点击这里下载<a href='install_lodop64.exe' target='_self'>执行安装</a>，安装后请刷新页面或重新进入。</font></div>";

    var strHtm64_Update = "<div style='height: 30px; line-height: 30px; font-size: 14px; text-align: center; padding: 0 10px; background: #f9e5e5'><font color='#FF00FF'>打印控件需要升级！点击这里下载<a href='install_lodop64.exe' target='_self'>执行升级</a>，升级后请重新进入。</font></div>";

    var strHtmFireFox = "<div style='height: 30px; line-height: 30px; font-size: 14px; text-align: center; padding: 0 10px; background: #f9e5e5'><font color='#FF00FF'>注意：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它，再重新下载安装！点击这里下载<a href='install_lodop32.exe' target='_self'>执行升级</a></font></div>";

    var strHtmChrome = "<div style='height: 30px; line-height: 30px; font-size: 14px; text-align: center; padding: 0 10px; background: #f9e5e5'><font color='#FF00FF'>如果此前正常，仅因浏览器升级或重安装而出问题，需重新执行以上安装！点击这里下载<a href='install_lodop32.exe' target='_self'>执行升级</a></font></div>";*/


    var strHtmInstall = returnHtml("install_lodop32.exe");
    var strHtmUpdate = returnHtml("install_lodop32.exe");

    var strHtm64_Install = returnHtml("install_lodop64.exe");
    var strHtm64_Update = returnHtml("install_lodop64.exe");
    var strHtmFireFox = returnHtml("install_lodop32.exe");
    var strHtmChrome = returnHtml("install_lodop32.exe");
    var LODOP, strHtmlTips;
    try {
        //=====判断浏览器类型:===============
        var isIE = (navigator.userAgent.indexOf('MSIE') >= 0) || (navigator.userAgent.indexOf('Trident') >= 0);
        var is64IE = isIE && (navigator.userAgent.indexOf('x64') >= 0);
        //=====如果页面有Lodop就直接使用，没有则新建:==========
        if (oOBJECT != undefined || oEMBED != undefined) {
            if (isIE)
                LODOP = oOBJECT;
            else
                LODOP = oEMBED;
        } else {
            if (CreatedOKLodop7766 == null) {
                LODOP = document.createElement("object");
                LODOP.setAttribute("width", 0);
                LODOP.setAttribute("height", 0);
                LODOP.setAttribute("style", "position:absolute;left:0px;top:-100px;width:0px;height:0px;");
                if (isIE) LODOP.setAttribute("classid", "clsid:2105C259-1E0C-4534-8141-A753534CB4CA");
                else LODOP.setAttribute("type", "application/x-print-lodop");
                document.documentElement.appendChild(LODOP);
                CreatedOKLodop7766 = LODOP;
            } else {
                LODOP = CreatedOKLodop7766;
            }
        }
        //=====判断Lodop插件是否安装过，没有安装或版本过低就提示下载安装:==========
        if ((LODOP == null) || (typeof(LODOP.VERSION) == "undefined")) {
            if (navigator.userAgent.indexOf('Chrome') >= 0) {
               // document.documentElement.innerHTML = strHtmChrome + document.documentElement.innerHTML;
                strHtmlTips = strHtmChrome;
            }
            if (navigator.userAgent.indexOf('Firefox') >= 0) {
              // document.documentElement.innerHTML = strHtmFireFox + document.documentElement.innerHTML;
                strHtmlTips = strHtmFireFox;
            }
            if (is64IE) {
              // document.write(strHtm64_Install);
                strHtmlTips = strHtm64_Install;
            }
            if (isIE) {
             //   document.write(strHtmInstall);
                strHtmlTips = strHtmInstall;
            } /*else {
              //  document.documentElement.innerHTML = strHtmInstall + document.documentElement.innerHTML;
                strHtmlTips = strHtmInstall;
            }*/

            $.dialog({
                title: "安装打印插件，让打印飞起来",
                content: strHtmlTips
            });

            return LODOP;
        } else if (LODOP.VERSION < "6.1.8.7") {
            if (is64IE) {
              //  document.write(strHtm64_Update);
                strHtmlTips = strHtm64_Update;
            } else if (isIE) {
              //  document.write(strHtmUpdate);
                strHtmlTips = strHtmUpdate;
            } else {
               // document.documentElement.innerHTML = strHtmUpdate + document.documentElement.innerHTML;
                strHtmlTips = strHtmUpdate;
            }

            $.dialog({
                title: "安装打印插件，让打印飞起来",
                content: strHtmlTips
            });

            return LODOP;
        }
        //=====如下空白位置适合调用统一功能(如注册码、语言选择等):====

        LODOP.SET_LICENSES("****技术有限公司","964587775717383919278901905623","","");

        //============================================================
        return LODOP;
    } catch (err) {
        if (is64IE)
            document.documentElement.innerHTML = "Error:" + strHtm64_Install + document.documentElement.innerHTML; else
            document.documentElement.innerHTML = "Error:" + strHtmInstall + document.documentElement.innerHTML;
        return LODOP;
    };
}

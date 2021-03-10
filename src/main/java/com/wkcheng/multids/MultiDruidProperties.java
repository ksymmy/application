package com.wkcheng.multids;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: created by ksymmy@163.com at 2019/8/20 16:18
 * @desc:
 */
@Data
public class MultiDruidProperties {

    private List<DruidProperties> multi = new ArrayList<>();

}

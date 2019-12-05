package com.zhiyou.mapper;

import com.zhiyou.model.Admin;

public interface AdminMapper {

	Admin selectByEmail(String accounts);

}

package com.wn.wooper.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SejongResultTableMapper {
	void sejongCreateMessageResult(String monthDay);
}

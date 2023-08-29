package com.wn.wooper.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RcsResultTableMapper {
	void rcsCreateMessageResult(String monthDay);
}

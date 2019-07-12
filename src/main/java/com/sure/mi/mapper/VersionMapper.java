package com.sure.mi.mapper;

import org.apache.ibatis.annotations.Param;

public interface VersionMapper {

    Long selectIdByVersionAndColor(@Param("version") String version, @Param("color") String color,
                                   @Param("productId") long productId);
    Long selectIdByNameAndVersionAndColor(@Param("name") String name,
                                          @Param("version") String version, @Param("color") String color);
}

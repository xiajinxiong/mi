package com.sure.mi.mapper;

import com.sure.mi.model.CartItem;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CartMapper {

    void addToCart(@Param("userId") long userId, @Param("productId") long productId,
                   @Param("versionId") long versionId);

    Integer selectNumber(@Param("userId") long userId, @Param("productId") long productId,
                     @Param("versionId") long versionId);

    void updateCart(@Param("userId") long userId, @Param("productId") long productId,
                    @Param("versionId") long versionId, @Param("number") int number);

    void deleteCart(@Param("userId") long userId, @Param("productId") long productId,
                    @Param("versionId") long versionId);

    List<CartItem> selectCartByUserId(long userId);
}

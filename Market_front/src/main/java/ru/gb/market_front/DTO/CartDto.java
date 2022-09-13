package ru.gb.market_front.DTO;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;


@Data
@RedisHash
public class CartDto {
    private String id;
    private List<CartListProductDto> cart;
}
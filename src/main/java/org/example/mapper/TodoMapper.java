package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Todo;
import org.springframework.stereotype.Component;


/**
 * @author mrawa_ltf
 */
@Component
public interface TodoMapper extends BaseMapper<Todo> {
}

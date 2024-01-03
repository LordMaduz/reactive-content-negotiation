package com.ruchira.content.negotiation.vo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@XmlRootElement()
@XmlType()
@NoArgsConstructor
@Data
public class RequestVo {

    private Long id;
    private String payload;
    private LocalDateTime localDateTime;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

}

package com.swapi.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Film {
    @JsonProperty("episode_id")
    private Integer episodeId;
    @JsonProperty("release_date")
    @Length(min = 1, max = 9, message = "error en la solicitud")
    private Date releaseDate;
    private String title;
}

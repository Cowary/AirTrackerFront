package org.cowary.arttrackerfront.entity.api.findRs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMediaRs {

    private List<Finds> findMedia;

}

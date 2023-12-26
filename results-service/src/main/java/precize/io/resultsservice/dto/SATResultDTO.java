package precize.io.resultsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SATResultDTO {
	private String name;
	private String address;
	private String city;
	private String country;
	private String pincode;
	private double satScore;
	private String passed;
}

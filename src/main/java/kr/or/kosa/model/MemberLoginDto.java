package kr.or.kosa.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MemberLoginDto {
	private String uid;
	private String pwd;
	private String name;
}

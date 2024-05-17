package paswords;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GetPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("rani"));
		System.out.println(encoder.encode("ritik"));
		System.out.println(encoder.encode("sita"));
		System.out.println(encoder.encode("hyd"));
	}
}

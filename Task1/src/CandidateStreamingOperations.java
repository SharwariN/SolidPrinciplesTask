import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

	
	public static void main(String[] args) {
		
		List<Candidate> candidateList = InterviewRepository.getCandidateList();

		// list candidate names from Pune city
		System.out.println("List of Pune Candidates:\n");
		candidateList.stream().filter(e -> e.getCity().equalsIgnoreCase("Pune")).
			forEach(System.out::println);
		System.out.println("--------------------------------");
		// list city and count of candidates per city
		System.out.println("\nCandidate count per city\n");
		Map<String, Long> countPerCity = candidateList.stream().
			collect(Collectors.groupingBy(Candidate :: getCity, Collectors.counting()));

		countPerCity.forEach((k,v) -> System.out.println(k+" -- "+v+"  time"));
		System.out.println("--------------------------------");
		// list technical expertise and count of candidates
		System.out.println("\nCandidate count by Technical Expertise\n");
			candidateList.stream().collect(Collectors.groupingBy(
			Candidate :: getTechnicalExpertise, Collectors.counting()))
			.forEach((k,v) -> System.out.println(k+" -- "+v));
		
		System.out.println("--------------------------------");
		// list fresher candidates
		System.out.println("\nFresher Candidate list\n");
		candidateList.stream().filter(e -> e.getYearsOfExperience() == 0).
			forEach(System.out::println);
		System.out.println("--------------------------------");
		
		// listing candidates with highest experience
		System.out.println("\nSorted List of Candidates by Experience\n");
		candidateList.stream().sorted((p1,p2) -> 
			(p1.getYearsOfExperience()-p2.getYearsOfExperience()))
			.forEach(System.out::println);
				
		System.out.println("--------------------------------");
		// sort the candidates by city name
		printLine();
		System.out.println("\nSorted List of Candidates by City Name\n");
		candidateList.stream().sorted((p1,p2) -> p1.getCity().compareTo(p2.getCity()))
		.forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}
}
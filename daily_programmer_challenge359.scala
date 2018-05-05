// See this Reddit challenge : https://www.reddit.com/r/dailyprogrammer/comments/8g0iil/20180430_challenge_359_easy_regular_paperfold/

def insert_numbers(init : List[Int], final_value : List[Int]) : List[Int] = {
	
	if (init.length == 1) {
	
			return final_value ++ List(1) ++ init ++ List(0)
		
		}else{
		
			insert_numbers(init.tail, final_value ++ List[Int](init.length % 2) ++ List[Int](init.head))
	
	}
		
}

// This stream implements the dragon curve sequence, an infinite automatic sequence of 0s and 1s. 
def anotherStream(init : List[Int]): Stream[List[Int]] = Stream.cons(init, anotherStream(insert_numbers(init, List[Int]())))

val infinite_dragon_curve = anotherStream(List(1))

infinite_dragon_curve(0)
infinite_dragon_curve(1)
infinite_dragon_curve(2)
infinite_dragon_curve(3)

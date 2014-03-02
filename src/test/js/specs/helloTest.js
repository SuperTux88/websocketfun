describe("hello", function() {
	describe("greet", function() {
		it("should greet the name", function(){
			expect(greet("felix")).toEqual("Hello felix");
		});
	});
});
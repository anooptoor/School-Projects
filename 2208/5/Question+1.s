		AREA 	prog1, CODE, READWRITE
		ENTRY
		ADR		r0, List	;Loads list into register 0				
		LDR		r1, LOOK	; loads search variable into register 1					
PROG	LDR		r3, [r0], #4	;loads next value into register 3					
		CMP		r1, r3			;compares with search variable			
		BEQ		DONE			;if true than branch to done				
		LDR		r0, [r0];		;lead next item in list
		CMP		r3, #0x00		;check for end of list
		BEQ		FAIL			; if true branch to fail				
		B		PROG			;loop back to check next value in list			
FAIL
		LDR		r2, FALSE		;load false value into register 2 if fails			
		B		INFIN			;branch to infin to avoid error			
DONE
		LDR		r2, TRUE		;load true value into register 2 if sucsesful			
INFIN	
		B 		INFIN			; branch infinity			
		AREA	prog1, DATA, READWRITE
List 	DCD 0x12341111, Item5
Item2 	DCD 0x12342222, Item3
Item3 	DCD 0x12343333, Item4
Item4 	DCD 0x12344444, Item6
Item5 	DCD 0x12345555, Item2
Item6 	DCD 0x12346666, Item7
Item7 	DCD 0x12347777, 0x00 
LOOK	DCD	0x12347777, 0				
TRUE	DCD	0xFFFFFFFF, 0				
FALSE	DCD	0xF0F0F0F0, 0				
		END
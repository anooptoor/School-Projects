		AREA program1, CODE, READONLY
		ENTRY
		
		LDR 	r0, =UPC		;Load The UPC Code
		MOV 	r4,#0			;used as point to digits in UPC
LOOP
		LDRB 	r5, [r0, r4]	;Adds current UPC digit into r5
		SUB 	r5,r5,#48		;Converts to usuable number
		ADD 	r1,r1,r5		;adds to total sum of odd

		ADD 	r4,r4,#1		;increment the pointer digit
		CMP 	r4, #11			;check if last digit
		BEQ 	QUIT			;Exit Loop
		
		LDRB 	r5,[r0, r4]		;adds UPC digit into r4
		SUB 	r5,r5,#48		;Converts to usuable number
		ADD 	r2,r2,r5		;adds to total sum of even
		
		ADD 	r4,r4,#1		;increment the pointer digit		
		B 		LOOP
		
QUIT	LDRB 	r5, [r0, r4]	;stores the check digit
		SUB 	r5,r5,#48		;Converts to usuable number
		ADD 	r1,r1,LSL #1	; multiplies by 3
		ADD 	r1,r1,r2		;adds sum of even to sum of odd
		SUB 	r1,r1,#1		;subtracts 1
		
DIV 
		SUBS 	r1,r1,#10	;subtracts 10 from total
		CMP 	r1,#10		;Compares to 10
		BGT 	DIV			;If greater than divide again
		
		RSB 	r1,r1,#9	;subtract combined digit from 9 and stores
		CMP 	r1,r5		;compares to check digit
		MOV 	r0, #0		;0 if not valid UPC
		MOVEQ 	r0, #1		;1 if valid UPC
		
ENDLOOP B 	ENDLOOP
		
		AREA program1, CODE, READWRITE
UPC		DCB	"013800150738"	;UPC string

		END
			
	AREA program2, CODE, READWRITE
	ENTRY

		LDR		r0, =WORD	;Loads the potential palindrome
		LDR		r1, =EoS	;Loads End of String 
		MOV		r2, #-1		;used to point to beginning of string
		MOV		r3, #0		;used to point to end of string
ITER
		ADD r2,r2,#1		;iterates begin
		SUB r3,r3,#1		;deincriments end
	
JUMP
		
		LDRB	r4, [r0, r2]	;loads current letter from 1st
		LDRB	r5, [r1, r3]	;loads current letter from end
		
		CMP		r4, #0x00		;compares to end of string
		BEQ		PASS			;if this true then ends because string is palindrome
		
		
		
		CMP		r4, #0x41		;checks if not letter
		ADDLT	r2, #1			;if yes skips letter
		BLT		JUMP			
		
		CMP 	r5, #0x41		;checks if not letter
		SUBLT 	r3, #1			;if true skips
		BLT		JUMP
		
		CMP		r4,	#0x5B		;checks if uppercase letter
		ADDLT	r4, #0x20 		;shifts it lowercase letter
				
		
		CMP 	r5,	#0x5B		;checks if uppercase letter
		ADDLT	r5, #0x20		'shifts it lowercase letter
		
		
		CMP		r4,	#0x61		;checks if between upper and lowercase letters, making it a non letter
		ADDLT	r2, #1			;if true skips
		BLT		JUMP
		
		CMP		r5,	#0x61		;checks if between upper and lowercase letters, making it a non letter
		SUBLT	r3, #1			;if yes skips
		BLT		JUMP
		
		CMP 	r4,	#0x7A		;if above lower case value then not letter
		ADDGT	r2, #1 			;if yes skips
		BGT		JUMP
		
		CMP     r5,	#0x7A		;if above lower case value then not letter
		SUBGT	r3, #1			;if yes skips
		BGT		JUMP
		
		CMP		r4, r5			;compares if two letters are the same
		
		BEQ ITER				;loops if they are same
		BNE FAIL				;ends and fails if not
PASS
	MOV	r0, #1					;puts 1 in r0 if pass
	B FINISH
		
FAIL		
	MOV r0, #0					;puts 0 in r0 if fail
FINISH

LOOP B LOOP						;endless loop
		
	
	AREA program2, DATA, READWRITE
WORD DCB "madram"
EoS DCB 0x00

	END

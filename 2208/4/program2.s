		AREA program2, CODE, READWRITE
		ENTRY
		
		
		LDR r3, =STRING1	;load word into register 3
		LDR r4, =STRING2	;load space into register 4
		
		MOV r0, #0x00		;move null string into register 0
start


		MOV r2, #0			;move 0 into register 2, our counter to iterate through characters
		MOV r9, #0			;move 9 into register 9, our counter to keep track of 'last used' byte in stored 
		
		
string

		LDRB r5, [r3, r2]	;load next character into register 5 
		CMP r5, #0x00		;compare to null, branch to end program if true. Signifies end of string
		BEQ done			;branch to end program
		
		
		CMP r5, #0x74		;compare to 't'
		BEQ checkt			;branche to checkt to check if its a the start of the word 'the'
		BNE store			;if not character 't' branch to end	
		
checkt
		
		CMP r2, #0			;check if this is the first character
		BEQ checkh			;branch to check if next character is h
		SUB r2, r2, #1		;subtract one from character counter, to see if what preceeds 't'
		LDRB r5, [r3, r2]	;load previous character into register '5'	
		
		CMP r5, #0x20		;check if its a space, 
		ADD r2, r2, #1		;restore counter to correct value
		BEQ checkh			;check if next character is h, if preceeding character is a space
		BNE store			;store character if not preceeded by space and is not first character
		
checkh
		ADD r2, r2, #1		;iterate character counter
		LDRB r5, [r3, r2]	;load next character
		
		CMP r5, #0x68		;compare character to 'h'
		BEQ checke			;if character is 'h' branch to checke
		SUBNE r2, r2, #1	;if it is not 'h' restore counter to correct value
		BNE store			;store value if it is not 'h'
checke
		ADD r2, r2, #1		;iterate character counter
		LDRB r5, [r3, r2]	;load next character
		
		CMP r5, #0x65		;check if it is 'e' 
		BEQ checkspace		;if it is 'e' branch to check if next checkspace
		SUBNE r2, r2, #2	;if not 'e' reset counter to correct value	
		BNE store 			;store value if not 'e'
checkspace
		ADD r2, r2, #1		;iterate character counter
		LDRB r5, [r3, r2]	;load next character
		
		CMP r5, #0x20		;compare to sapce
		ADDEQ r2, r2, #1	;iterate character counter
		BEQ string			;continue anaylizing next character, this is where 'the' is officially skipped
		
		CMP r5, #0x00		;check if end of string, another case where 'the' must be ignored'	
		BEQ string			;jump back start where program termination is handeled	
		
		SUBNE r2, r2, #3	;reset character counter to 'pre' checking for 'the' value b
		BNE store			;store values that were checked if not 'space' or end of string
store	

		LDRB r5, [r3, r2]	;load character most character to be stored
		STRB r5, [r4, r9]	;store character in register 4
		
		ADD r9, r9, #1		;iterate storage counter
		ADD r2, r2, #1		;iterate character counter
		
		B string			;branch to check next string
done

		STRB r0, [r4, r9]	;at very end of program add null character to end of string
		
loop	
		B loop				;endless loop to end program
		
		
		AREA program2, DATA, READWRITE
STRING1 DCB " and the man said they must go" ;String1
EoS DCB 0x00 ;end of string1
STRING2 space 0xFF 
		END
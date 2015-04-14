		AREA program1, CODE, READWRITE
		ENTRY

		LDR r3, =STRING1	;loads first string into register 3
		LDR r4, =STRING3	;load space into regist 4
		MOV r0, #0x00		;load null character into register 0
		
start
		MOV r2, #0			;move 0 into register 2, acts as character counter
string
		LDRB r5, [r3, r2]	;loads current character into register 5
		ADD r2, r2, #1		;iterate character counter
		CMP r5, #0x00		;compare to null string
		BNE storing			;if not equal to null, then store current string
		
		CMP r7, #0			;check if register 7 'flag' is 0
		BNE done ;done		;if not 0 then we have finished storing second string, branch to done
		LDR r3, =STRING2	;if equals 0 then load second string
		ADD r7, r7, #1		;mark flag as 'second string completed'
		B start				;repeat process for string 2, branch to start
storing
		STRB r5, [r4, r6]	;store current character in register 4 , register 6 used to keep track of last used space
		ADD r6, r6, #1		;iterate storage counter
		B string			;branch to anaylze next character
		
done
		STRB r0, [r4, r6]	;store null string at end of concatnated string			
		
		
		AREA program1, DATA, READWRITE
STRING1 DCB "This is a test string1" ;String1
EoS 	DCB 0x00 ;end of string1
STRING2 DCB "This is a test string2" ;String
EoS2 	DCB 0x00 ;end of string2
STRING3 space 0xFF 
				
		END
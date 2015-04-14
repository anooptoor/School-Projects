		AREA program3, CODE, READWRITE
		ENTRY
		
		LDR	sp, =0x00		;load 0x00 to intialize stack 
		STMFD sp!,{r2, lr}	;push value of r2 onto stack
		MOV r0, #0x03		;store value of x in r0
		
		LDR r1, VALA		;store value of A in r1
		MUL r2, r0, r1 		;calculates Ax
		
		LDR r1, VALB		;store value of B in r2
		ADD r2, r1, r2		;calculate Ax + B
		MUL r2, r0, r2		;calculates Ax*x + Bx
		
		LDR r1, VALC		;store value of C in r1
		ADD r0, r2, r1		;calculates Ax*x + Bx + C
		
		LDR r2, VALD		;store value of D in r2		
		CMP r0, r2			;compare value of r0 to D 		
		BGT	clip			;branch to clip if r0 > D
		ADD r1, r0, r0		;calculates double value of r0 and stores in r1
fin		
		LDMFD 	sp!,{r2, pc}	;pop value of r2 off stack	
		
loop	
		B loop
clip	
		LDR r0, VALD		;clip r0 to D
		ADD r1, r0, r0		;calculates 2 x r0 and store in r1
		B fin				;branch to ending code
		
		
		AREA	program3, DATA, READWRITE
VALA	DCD		0x05					
VALB	DCD		0x06					
VALC	DCD		0x07					
VALD	DCD		0x90	
EMPT	DCD 	0x00	
		END
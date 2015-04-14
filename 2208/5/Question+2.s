
     AREA prog2, CODE, READONLY
x    EQU 2
n    EQU 2
     ENTRY
Main 
	 ADR   sp,stack      ;init stack pointer
     MOV   r8, #x        ;put value x in register 8
	 MOV   r9, #n        ;put value n in register 9
     STR   r9,[sp,#-4]!	 ;put value of n on stack	
     SUB   sp,sp,#4      ;reserve space for return value
     BL    MULT           ;branch to mult to calculate X to the power of n
     LDR   r0,[sp],#4    ;load register from stack
     ADD   sp,sp,#4      ;remove the parameter from the stack
     ADR   r1,result     ;load result to register 1
     STR   r0,[r1]       ;store final result in result variable

infin 
	B     infin          
     AREA prog2, CODE, READONLY
MULT 
	STMFD 	sp!,{r0,r1,r2,fp,lr} ;push general registers, as well as fp and lr  
    MOV   	fp,sp         		 ;set the fp for this call	

    LDR   	r0,[fp,#0x18]        ;get parameter from stack
    CMP   	r0,#0                ;check if value is 0(end of program)
    BNE   	EVEN                 ;brach to even
    MOV 	r0,#1                ;move 1 into register 0
    STR 	r0,[fp,#0x14]        ;update value in r0
    BEQ   	return               ;if equal branch to end program

EVEN
    TST		r0, #1               ;bitwise and with 1 to check even or odd
    BNE    	ODD                  ;branch to odd if not equal
    SUB    	r0,r0,#1             ;subract 1 from r0
    STR    	r0,[sp,#-4]!         ;store r0
    SUB    	sp,sp,#4             ;reserve place for return value
    BL     	MULT                 ;branch with link to mult
    LDR    	r0,[sp],#4           ;load the result in r0 and pop it from the stack 
    ADD    	sp,sp,#4             ;remove the paramater from stack 
    MUL    	r1,r0,r8             ; prepare the value to be returned 
    STR    	r1,[fp,#0x14]        ;store the returned value in the stack 
    B    	return               ; branch to end program

ODD
    LSR    	r0,r0,#1             ;logical shift right r0
    STR    	r0,[sp,#4]!          ;store value on stack
    SUB    	sp,sp,#4             ;reserve place for return value  
    BL     	MULT                 ;branch to mult 
    LDR    	r0,[sp],#4           ;load the result in r0 and pop it from the stack 
    MOV    	r1,r0                ;move value into r1 
    ADD    	sp,sp,#4             ;remove also the parameter from the stack 
    MUL    	r2,r1,r0             ;multiply to get final value
    STR    	r2,[fp,#0x14]        ;store the returned value in the stack 
    B    	return               ; branch to end program 

return  
	MOV   	sp,fp         
    LDMFD 	sp!,{r0,r1,r2,fp,pc} 

     AREA prog2, DATA, READWRITE
result DCD   0x00        
       SPACE 0xB4       
stack  DCD   0x00        

       END
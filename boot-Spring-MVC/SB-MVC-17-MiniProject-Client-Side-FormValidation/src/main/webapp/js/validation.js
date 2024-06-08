function doValidation(frm){
	
	
	let enameEle=document.getElementById("enameErr");
	let jobEle=document.getElementById("jobErr");
	let salEle=document.getElementById("salErr");
	let deptnoEle=document.getElementById("deptnoErr");
	let flag=true;

    enameEle.innerHTML="";
    jobEle.innerHTML="";
    salEle.innerHTML="";
    deptnoEle.innerHTML="";

    let ename=frm.ename.value;
    let job=frm.job.value;
    let sal=frm.sal.value;
    let deptno=frm.deptno.value;
    if(ename==""){
		enameEle.innerHTML="Name Cannot be Empty..!"
    	flag=false;
    }
    else if(ename.length<5 ||ename.length>15){
		enameEle.innerHTML="Name Length shound be in range 5 to 15 Characters..!";
		flag=false;
	}
	if(job==""){
		jobEle.innerHTML="Job Cannot be Empty..!";
		flag=false;
	}
	else if(job.length<5 || job.length>15){
		jobEle.innerHTML="Job Length shound be in range 5 to 15 Characters..!";
	}

	if(isNaN(sal)){
		salEle.innerHTML="Salary Must be an Number..!";
		flag=false;
	}
	else if(sal<200 || sal>50000){
		salEle.innerHTML="Salary Must be in Range 200 to 50000.0..!";
		flag=false;
	}
	if(isNaN(deptno)){
		deptnoEle.innerHTML="Deptno Must be an Number..!";
		flag=false;
	}
	else if(!(deptno==10|| deptno==20 || deptno==30)){
		deptnoEle.innerHTML="Deptno Must be 10 or 20 or 30..!";
		flag=false;
	}
	return flag;
}
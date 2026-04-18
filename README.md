# HclTech-Hackathon
HclTech-Hackathon

user Stories":
ENtities-- 
	Users Table
	CreditCard Table
	CardAccount Table
	Application
	
	

1) basic information -- table -- users
	UserId -- varchar (UUID) primary key
	firstName-- varchar
	lastName -- varchar
	Email -- varchar (unique)
	phone number-- long
	employee type-- varchar
	companyName-- varchar
	AnnualIncome-- long
	PAN-- varchar
	password -- int
	created at -- timestamp
	CreditScore
	
	--submit application
	
2)Entity cards -- table -- creditcard
	UniqueId -- varchar (UUID) primary key
	cardType -- varchar
	max credit -- long
	min creditScore -- long
	card limit -- long
	annual fee -- long

3)Enity creditCardAccount --table
	UniqueId -- varchar (UUID) primary key
	credit_card_Id (Foreign key)--
	cardnumber -- bigint
	cvv -- int
	UserId (Foreign key)--
	expiry_date --varchar
	creditlimit-- longint
	limitAvailable -- longint
	cardStatus --varchar


4)Application
	User_Id (Foreign key)--
	Status --varchar (Pending/Approved/ Rejected)
	credit_Card_Id (Foreign key)--
	appliedDate--timestamp
	approvedDate--timestamp
	
________________________________________________________

endpoints--

	postmapping -- Apply credit card
		requrest - {
			firstName:
			lastName:
			Email:
			phone number:
			employee type:
			companyName:
			AnnualIncome:
			PAN:
		}
		
		response - {
			ApplicationId: 
			CreditScore:
			UserId:
		}
	
	getMapping --Get eligible cards
		requestHeaders: ApplicationId
	
		response:{
			UserId:
			ApplicationId;
			AvailableCards[]:
		
		}
	
	postmapping--Card allocation
	requestHeaders: cardId, applicationId
	response{
		CardType
		CardNumner:
		PIN:
		expDate:
		limit:
		Message:
		UserName:
		Password:
	}
	
	postMapping -- Api/Auth/login page
	requestBody{
		Username:
		Password:
	}
	
	response:{
		FirstName:
		LastName:
		Email:
		UserId:
		Message:
	}
	

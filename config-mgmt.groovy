def checkName()
{
    return "config-mgmt";
}

def Operate(){
    echo checkName() + " Operate Check is finished"
}

def Optimize(){
    echo checkName() + " Optimize Check is finished"
}

def Secure(){
    echo checkName() + " Secure Check is finished"
}

def Scale(){
    echo checkName() + " Scale Check is finished"
}

def Summary(){
    echo checkName() + " Summary Check is finished"
}

return this;
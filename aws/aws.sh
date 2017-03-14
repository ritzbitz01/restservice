# Create the security group and allow incoming traffic over port 22. This command will return a Security Group Id that will need to be saved.
aws ec2 create-security-group --group-name gocd-sg --description "security group for GoCD Demo"
aws ec2 authorize-security-group-ingress --group-name gocd-sg --protocol tcp --port 22 --cidr 0.0.0.0/0
aws ec2 create-key-pair --key-name gocd-key --query 'KeyMaterial' --output text > gocd-key.pem

#Launch and connect to the instance, need security group id from previous step. This command will return an instance id.
aws ec2 run-instances --image-id ami-9da98cf8 --security-group-ids sg-e31d8c8a --count 1 --instance-type t2.micro --key-name gocd-key --query 'Instances[0].InstanceId'

#Retrieve the ip address of the created instance. Will need the instance id from the previous step. This command will return the IP Address of the instance.
aws ec2 describe-instances --instance-ids i-ec3e1e2k --query 'Reservations[0].Instances[0].PublicIpAddress'

#Connect to the instance via ssh, need the ip address retrieved from the previous step.
ssh -i gocd-key.pem ubuntu@54.183.22.255

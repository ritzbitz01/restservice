import boto3, sys

def main(argv):
    os = sys.argv[1]
    amifilter = ''
    ec2 = boto3.client('ec2')

    if(os == 'ubuntu1604'):
        amifilter = 'ubuntu1604-lts-pso-autoami-*'

    filters = [{
        'Name': 'name',
        'Values': [amifilter]
    }]

    images = ec2.describe_images(Filters=filters)

    for image in images["Images"] :
        print image["ImageId"]

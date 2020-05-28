# https://www.hackerrank.com/challenges/class-1-dealing-with-complex-numbers/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
#
# Classes: Dealing with Complex Numbers

# For this challenge, you are given two complex numbers, and you have to print the result of their addition, subtraction,
# multiplication, division and modulus operations.
class Complex(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def __add__(self, other):
        return Complex(self.real + other.real, self.imaginary + other.imaginary)

    def __sub__(self, other):
        return Complex(self.real - other.real, self.imaginary - other.imaginary)

    def __mul__(self, other):
        # (a+bi)(c+di)=(ac-bd)+(bc+ad)i
        return Complex(self.real * other.real - self.imaginary * other.imaginary, self.imaginary * other.real + self.real * other.imaginary)

    def __truediv__(self, other):
        try:
            return Complex((self.real * other.real + self.imaginary * other.imaginary)/(other.real**2 + other.imaginary**2),
                           (self.imaginary * other.real - self.real * other.imaginary)/(other.real**2 + other.imaginary**2))
        except ZeroDivisionError as e:
            print(e)
            return None

    def mod(self):
        return Complex(pow(self.real**2 + self.imaginary**2, 0.5), 0)

    def __str__(self):
        if self.imaginary == 0:
            result = "%.2f+0.00i" % self.real
        elif self.real == 0:
            if self.imaginary >= 0:
                result = "0.00+%.2fi" % self.imaginary
            else:
                result = "0.00-%.2fi" % (abs(self.imaginary))
        elif self.imaginary > 0:
            result = "%.2f+%.2fi" % (self.real, self.imaginary)
        else:
            result = "%.2f-%.2fi" % (self.real, abs(self.imaginary))
        return result


if __name__ == '__main__':
    c = map(float, input().split())
    d = map(float, input().split())
    x = Complex(*c)
    y = Complex(*d)
    print(*map(str, [x + y, x - y, x * y, x / y, x.mod(), y.mod()]), sep='\n')
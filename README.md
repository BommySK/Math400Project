The FatPointMatrix class gives static methods for determining the existence of a polynomial of degree d in n variables that vanishes to order m at a fixed point. In particular, if d, n, and m are specified, the constructor builds a data type which contains the information of the linear conditions the coefficients of a homogeneous degree-d polynomial in n variables must satisfy in order to vanish at the point (1, … , 1).  The constructor is also overloaded to allow one to specify which coefficients are allowed to be nonzero. The static methods allow one to recover these linear conditions in matrix form, and determine the rank of such a matrix.

In [P], Paul shows that the rank of such a matrix (for homogeneous polynomials) is equal to the rank of the corresponding matrix for a general point in affine space. These calculations of rank are important for carrying out the reduction method of Dumnicki [D1] and Paul [P], for determining the non-speciality of linear systems in the projective plane.

Dumnicki also shows in [D2] that the matrix we find has full rank if and only if there exists a degree-m polynomial with rational coefficients which vanishes at the exponent vectors of each allowed monomial.

This project was done in collaboration with Dr. Stepan Paul of the Cal Poly Mathematics Department. We came together to work on this due to our intrigue in this Mathematical problem and its interesting implementation possibility in Java (or any programming language for that matter). 

[D1] Marcin Dumnicki, Cutting diagram method for systems of plane curves with base points, Ann. Polon. Math. 90  (2007), no. 2, 131{143. MR 2289179 (2008d:4048)}

[D2] —, Expected term bases for generic multivariate Hermite interpolation, Appl. Algebra Engrg. Comm. Comput. 18 (2007), no. 5, 467–482. M R2342565 (2008j:41003)

[P] Stepan Paul, New methods for determining speciality of linear systems based at fat points in P^n, Journal of Pure and Applied Algebra 217  (2013), no. 5, 927  – 945. (preprint available at arXiv:1205.1773)

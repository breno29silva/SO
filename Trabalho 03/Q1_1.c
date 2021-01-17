#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int* values; /* this data is shared by the thread(s) */
void* runner(void* param); /* the thread */
int main(int argc, char* argv[])
{
	int terms = atoi(argv[1]);
	pthread_t tid; /* the thread identifier */
	pthread_attr_t attr; /* set of attributes for the thread */
	if (argc != 2) {
		fprintf(stderr, "usage: a.out <integer value>\n");
		exit(1);
	}
	if (terms < 0) {
		fprintf(stderr, "Argument %d must be non-negative\n", terms);
		exit(1);
	}
	values = (int*)malloc(terms * sizeof(int))
		pthread_attr_init(&attr);
	pthread_create(&tid, &attr, runner, terms);
	pthread_join(tid, NULL);
	printf("The first %d elements are: ", terms);
}

void* runner(void* terms)
{
	int i, upper = atoi(terms);
	if (upper > 0) {
		for (i = 0; i < upper; i++)
			v[i] = fibonacci(i);
	}
	pthread_exit(0);
}

int fibonacci(int term) {
	if (term == 0) {
		return 0;
	}
	else if (term == 1) {
		return 1;
	}
	else {
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
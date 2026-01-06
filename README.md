# MySample - Spring Boot API Application

A simple Spring Boot REST API application with Docker support.

## Requirements

- Java 17+
- Maven 3.8+
- Docker (optional)

## Quick Start

### Run Locally

```bash
# Clone the repository
git clone https://github.com/thanhtrinity/mysample.git
cd mysample

# Build and run
./mvnw spring-boot:run
```

### Run with Docker

```bash
# Build Docker image
docker build -t mysample:latest .

# Run container
docker run -p 8080:8080 mysample:latest
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/health` | Health check endpoint |
| GET | `/api/hello` | Hello endpoint (optional: `?name=YourName`) |
| GET | `/api/info` | Application info |
| POST | `/api/echo` | Echo back the request body |
| GET | `/actuator/health` | Spring Actuator health |

## Examples

### Health Check
```bash
curl http://localhost:8080/api/health
```

### Hello
```bash
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/hello?name=Spring
```

### Echo
```bash
curl -X POST http://localhost:8080/api/echo \
  -H "Content-Type: application/json" \
  -d '{"message": "Hello World"}'
```

## Running Tests

```bash
./mvnw test
```

## Docker Build & Push

The application includes GitHub Actions for automatic Docker image build and push to GitHub Container Registry.

### Manual Push

```bash
# Login to GHCR
echo $GITHUB_TOKEN | docker login ghcr.io -u USERNAME --password-stdin

# Build and tag
docker build -t ghcr.io/thanhtrinity/mysample:latest .

# Push
docker push ghcr.io/thanhtrinity/mysample:latest
```

## License

MIT License

